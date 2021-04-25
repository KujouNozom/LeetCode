package com.sxg.leetcode.question.data2020_0x.no0101_0150;

/**
 * @ClassName: Question0134
 * @Author: Su_N
 * @Date: 2020/6/1 7:16
 * @Description: 一次遍历
 * 题解：
 * 我们使用三个临时变量
 * totleCount 记录从0号加油站到遍历目前为止油箱剩余的油（可以为负数）
 * startIndex 记录出发点位置，初始为0，后续当遇到无法到达的站点的时候，重新初始化为无法到达的站点
 * currentCount 记录从出发站点 startIndex 到遍历目前为止油箱剩余的油,如果小于0，说明无法到达下一个站点，将currentCount设置为0，startIndex设置为下一个站点
 * <p>
 * 遍历的时候，每一步 currentCount = currentCount + (gas[n] - cost[n])
 * 当遍历结束的时候 totleCount <0 则无解,totleCount >=0 则 startIndex 为题解
 * 原因是：
 * 我们设 temp[n] = gas[n] - cost[n],一共有N个站点
 * 我们设在遍历过程中有k1+1,k2+1,k3+1...kn+1个无法到达的点，由上面的公式可知
 * sum(k1+1 - k2,temp[n])  = currentCount < 0
 * sum(k2+1 - k3,temp[n])  = currentCount < 0
 * ...
 * sum(kn-1 +1 - kn,temp[n])  = currentCount < 0
 * sum(kn+1 - N,temp[n]) = currentCount >=0,因为如果currentCount<0，则中间存在无法到达的站点，kn就应该是这个站点
 * sum(0 - k1) = currentCount >=0,因为如果currentCount<0，则中间存在无法到达的站,k1 应该是这个站点
 * totleCount =  sum(0 - k1) + sum(k1+1 - k2,temp[n]) + sum(k2+1 - k3,temp[n]) + ... sum(kn-1 +1 - kn,temp[n]) + sum(kn+1 - N,temp[n])
 * sum(k1+1 - k2,temp[n]) + sum(k2+1 - k3,temp[n]) + ... sum(kn-1 +1 - kn,temp[n]) 肯定是小于0，的因为每一项都小于0
 * 所以如果 totleCount >=0 则 sum(0 - k1)  + sum(kn+1 - N,temp[n]) >0，表示从kn+1 可以到达 k1
 * 同时 sum(0 - k1)  + sum(kn+1 - N,temp[n]) 每加一个 sum(kn-1 +1 - kn,temp[n]) 都是正数，因为后面每一个项都是负数，如果当前就为负数，则后面加完的结果 totleCount 肯定是负数
 * 因此 kn 环游一周是可达的
 * <p>
 * 如果totleCount <0 ,则加每一项的时候会出现负数，环游一周的途中有不可达的站，无解
 * <p>
 * <p>
 * <p>
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明:
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * <p>
 * 输出: -1
 * <p>
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totleCount = 0;
        int currentCount = 0;
        int startIndex = 0;

        for (int index = 0; index < gas.length; index++) {
            int temp = gas[index] - cost[index];
            totleCount += temp;
            currentCount += temp;
            if (currentCount < 0) {
                currentCount = 0;
                startIndex = index + 1;
            }
        }

        return totleCount < 0 ? -1 : startIndex;
    }
}
