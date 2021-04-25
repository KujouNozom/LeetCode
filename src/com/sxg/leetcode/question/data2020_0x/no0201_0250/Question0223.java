package com.sxg.leetcode.question.data2020_0x.no0201_0250;

/**
 * @ClassName: Question0223
 * @Author: Su_N
 * @Date: 2020/6/29 22:52
 * @Description: 首选判断两个矩形是否相交，通过点的左边可以判断
 * 如果不想交，覆盖面积是两个矩形面积之和 s1 + s2
 *
 * 如果相交的话，面积等于两个矩形面积相加s1 + s2 再减去重叠的面积 s3
 * 重叠的面积计算可以先确认重叠矩形的四个边
 * 左边的 x 是两个矩形左边靠右的那个
 * 右边的 x 是两个矩形右边靠左的那个
 * 上边的 y 是两个矩形上边靠下的那个
 * 下边的 y 是两个矩形下边靠上的那个
 *
 * 223. 矩形面积
 *
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 *
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 *
 * Rectangle Area
 *
 * 示例:
 *
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 *
 * 说明: 假设矩形面积不会超出 int 的范围。
 */
public class Question0223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int s1 = (C - A) * (D - B);
        int s2 = (G - E) * (H - F);
        if (A >= G || B >= H || C <= E || D <= F) {
            return s1 + s2;
        }

        // 左边的 x 是两个矩形左边靠右的那个
        int I = Math.max(A, E);

        // 下边的 y 是两个矩形下边靠上的那个
        int J = Math.max(B, F);

        // 右边的 x 是两个矩形右边靠左的那个
        int K = Math.min(C, G);

        // 上边的 y 是两个矩形上边靠下的那个
        int L = Math.min(D, H);

        int s3 = (K - I) * (L - J);

        return s1 + s2 - s3;
    }
}
