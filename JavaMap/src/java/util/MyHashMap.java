package java.util;

import java.util.HashMap.Node;
import java.util.HashMap.TreeNode;

public class MyHashMap<K,V> extends HashMap<K,V>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public V put(K key, V value) {
        return MyPutVal(hash(key), key, value, false, true);
    }
	
	public V MyPutVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
		//�ֲ��������ڱ��浱ǰHashMap��Node����
		Node<K, V>[] tab = table;
		//Node�����в���λ�õ�Node
		Node<K, V> p;
		//Node���鳤��
		int n = tab.length;
		//Node�����в���λ�õ�index
		int i;
		if (tab == null || n == 0) {
			//��ʼ��Node����
			tab = myResize();
			n = tab.length;
		}
		//hash��ȡNode����index
		i = (n - 1) & hash;
		p = tab[i];
		//�ж�����Ŀ��Node�Ƿ�Ϊ��
		if (p == null) {
			//��Ŀ��λ�ý��и�ֵ
			tab[i] = newNode(hash, key, value, null);
		} else {
			//Node�������λ�õ�Node
			Node<K, V> e;
			//Node�������λ��Node��key
			K k = p.key;
			//�ж�Ŀ��key��hash�Ƿ���ڵ�ǰ����key��hash �� key��ȫ���
			if (p.hash == hash && (k == key || (key != null && key.equals(k))))
				//key��ͬ
				e = p;
			else if (p instanceof TreeNode)
				//key��ͬ,��pΪTreeNode(���ڵ�),����TreeNode��������,��ȡ����λ�õ�Node
				e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);
			else {
				//key��ͬ,���б���Node����
				for (int binCount = 0;; ++binCount) {
					e = p.next;
					//p.nextΪ��,�򴴽���Node
					if (e == null) {
						p.next = newNode(hash, key, value, null);
						//�ж�Node�����Ƿ�ý�����չ
						if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
							treeifyBin(tab, hash);
						break;
					}
					//p.next��Ϊ��,��key��ͬ������ѭ��
					if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
						break;
					//p.next��Ϊ��,��key����ͬ����p.next����p��������
					p = e;
				}
			}
			//��Node�������λ�õĲ�Ϊ�յ�Node�����滻ԭ��ֵ
			if (e != null) { // existing mapping for key
				V oldValue = e.value;
				if (!onlyIfAbsent || oldValue == null)
					e.value = value;
				afterNodeAccess(e);
				return oldValue;
			}
		}
		++modCount;
		//�ж�Node�����Ƿ�ý�����չ
		if (++size > threshold)
			myResize();
		afterNodeInsertion(evict);
		return null;
	}
	
	
	private Node<K,V>[] myResize() {
		//��չǰNode����
        Node<K,V>[] oldTab = table;
        //��չǰNode���鳤��
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        //��չǰ����չ�ٽ��
        int oldThr = threshold;
        //��չ��Node���鳤��
        int newCap = 0;
        //��չ�����չ�ٽ��
        int newThr = 0;
        //����չǰNode���鳤�ȴ���0
        
        
        //step1:��ʼ��newCap��newThr
        if (oldCap > 0) {
            
            //��չǰNode���鳤���Ѿ�������޶�
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            //����չ��Node���鳤��С������޶ȣ�����չǰNode���鳤�ȴ���Ĭ�ϳ���
            //��չ�����չ�ٽ�� = ��չǰ����չ�ٽ��*2
            //��չ��Node���鳤�� = ��չǰNode���鳤��*2
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        //����չǰNode���鳤�Ȳ�����0������չǰ����չ�ٽ�����0
        //��֪��ʲôʱ�������ⲽ����
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        
        //����չǰNode���鳤�Ȳ�����0������չǰ����չ�ٽ�㲻����0�����г�ʼ������
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        
        //��֪��ʲôʱ�������ⲽ����
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        

        //step2:������Node���鲢����ԭ������
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        
        //����ԭ������
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
            	//������Node
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    /* ��û����Node��ֱ������hash�볤�Ƚ���λ������ȷ��λ��
                     * ԭ�в�ͬλ�û᲻��õ�ͬ��λ�ã�
                     * ���ᣬ����ԭ�в����Ѿ�������ײ�����ڣ�hash��ɳ���-1λ�����㣩��λ���루hash���³���-1λ�����㣩��λ�ô�����
                     * ������־�λ�ò�ͬ����λ����ͬ�������,�����³���=�ɳ���*2,������λ����λ��������ֻ���ڶ������и�λ����һλ.
                     * (��ʹ��Ҷ�-1Ҳ����ͬ���)
                     * */
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else {
                    	//������Node
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
}
