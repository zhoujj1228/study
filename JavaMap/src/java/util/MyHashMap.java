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
		//局部变量用于保存当前HashMap的Node数组
		Node<K, V>[] tab = table;
		//Node数组中插入位置的Node
		Node<K, V> p;
		//Node数组长度
		int n = tab.length;
		//Node数组中插入位置的index
		int i;
		if (tab == null || n == 0) {
			//初始化Node数组
			tab = myResize();
			n = tab.length;
		}
		//hash获取Node数组index
		i = (n - 1) & hash;
		p = tab[i];
		//判断数组目标Node是否为空
		if (p == null) {
			//对目标位置进行赋值
			tab[i] = newNode(hash, key, value, null);
		} else {
			//Node链表插入位置的Node
			Node<K, V> e;
			//Node数组插入位置Node的key
			K k = p.key;
			//判断目标key的hash是否等于当前插入key的hash 且 key完全相等
			if (p.hash == hash && (k == key || (key != null && key.equals(k))))
				//key相同
				e = p;
			else if (p instanceof TreeNode)
				//key不同,且p为TreeNode(树节点),进行TreeNode插入流程,获取插入位置的Node
				e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);
			else {
				//key不同,进行遍历Node链表
				for (int binCount = 0;; ++binCount) {
					e = p.next;
					//p.next为空,则创建新Node
					if (e == null) {
						p.next = newNode(hash, key, value, null);
						//判断Node链表是否该进行扩展
						if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
							treeifyBin(tab, hash);
						break;
					}
					//p.next不为空,且key相同，跳出循环
					if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
						break;
					//p.next不为空,且key不相同，把p.next赋予p继续遍历
					p = e;
				}
			}
			//对Node链表插入位置的不为空的Node进行替换原有值
			if (e != null) { // existing mapping for key
				V oldValue = e.value;
				if (!onlyIfAbsent || oldValue == null)
					e.value = value;
				afterNodeAccess(e);
				return oldValue;
			}
		}
		++modCount;
		//判断Node数组是否该进行扩展
		if (++size > threshold)
			myResize();
		afterNodeInsertion(evict);
		return null;
	}
	
	
	private Node<K,V>[] myResize() {
		//拓展前Node数组
        Node<K,V>[] oldTab = table;
        //拓展前Node数组长度
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        //拓展前的拓展临界点
        int oldThr = threshold;
        //拓展后Node数组长度
        int newCap = 0;
        //拓展后的拓展临界点
        int newThr = 0;
        //当拓展前Node数组长度大于0
        
        
        //step1:初始化newCap和newThr
        if (oldCap > 0) {
            
            //拓展前Node数组长度已经超最大限度
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            //当拓展后Node数组长度小于最大限度，且拓展前Node数组长度大于默认长度
            //拓展后的拓展临界点 = 拓展前的拓展临界点*2
            //拓展后Node数组长度 = 拓展前Node数组长度*2
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        //当拓展前Node数组长度不大于0，且拓展前的拓展临界点大于0
        //不知道什么时候会进行这步操作
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        
        //当拓展前Node数组长度不大于0，且拓展前的拓展临界点不大于0，进行初始化操作
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        
        //不知道什么时候会进行这步操作
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        

        //step2:创建新Node数组并复制原有数据
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        
        //复制原有数据
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
            	//遍历的Node
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    /* 当没有子Node，直接重新hash与长度进行位与运算确定位置
                     * 原有不同位置会不会得到同样位置？
                     * 不会，由于原有插入已经进行碰撞处理，在（hash与旧长度-1位与运算）旧位置与（hash与新长度-1位与运算）新位置处理上
                     * 不会出现旧位置不同而新位置相同这种情况,由于新长度=旧长度*2,所以新位置在位与运算中只是在二进制中高位多了一位.
                     * (即使大家都-1也是相同结果)
                     * */
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else {
                    	//当有子Node
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
