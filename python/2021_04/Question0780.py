# 780. 到达终点 [数学，取模除法]
class Solution:
    def reachingPoints(self, sx: int, sy: int, tx: int, ty: int) -> bool:
        # not (sx > tx or sy > ty) and not (sx == tx and sy == ty)
        #   sx<=tx and sy <= ty abd (sx != tx or sy != ty)
        # 通过逻辑运算定律转换为
        while tx != ty and sx <= tx and sy <= ty and (sx != tx or sy != ty):
            if tx > ty:
                if ty == sy:
                    return (tx - sx) % ty == 0
                tx, ty = tx % ty if tx % ty else ty, ty
            elif tx < ty:
                if tx == sx:
                    return (ty - sy) % tx == 0
                tx, ty = tx, ty % tx if ty % tx else tx

        return sx == tx and sy == ty
