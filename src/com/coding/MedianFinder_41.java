package coding;

import java.util.PriorityQueue;
import java.util.Queue;

/*剑指 Offer 41. 数据流中的中位数
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例 1：

输入：
["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
[[],[1],[2],[],[3],[]]
输出：[null,null,null,1.50000,null,2.00000]
示例 2：

输入：
["MedianFinder","addNum","findMedian","addNum","findMedian"]
[[],[2],[],[3],[]]
输出：[null,null,2.00000,null,2.50000]
 

限制：

最多会对 addNum、findMedia进行 50000 次调用。*/

//https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
//用两个堆，一个堆保存数组中较大的一半，另一个堆保存数组中较小的一半。中位数就是 装较大一半的堆 中 取 最小的那个 + 装较小一半的堆 中 取 最大的那个， 然后 /2 (两个堆size相同的情况下)
// 要是size不相同，因为较大的那个堆多存一个，所以就把较大的那个堆的最小那个输出就可以
public class MedianFinder_41 {
    Queue<Integer> A;
    Queue<Integer> B;

    /** initialize your data structure here. */
    public MedianFinder_41() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if(A.size() != B.size()){
            A.add(num);
            B.add(A.poll());
        }else{
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() == B.size() ? (A.peek() + B.peek()) / 2.0 : A.peek();
    }
}

///**
//  * Your MedianFinder object will be instantiated and called as such:
//  * MedianFinder obj = new MedianFinder();
//  * obj.addNum(num);
//  * double param_2 = obj.findMedian();
//  */