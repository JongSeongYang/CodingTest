# 줄 서는 방법

import math
def solution(n, k):
    answer = []
    arr = [i for i in range(1,n+1)]
    while n>0:
        f = math.factorial(n-1)
        idx ,k = (k-1) // f, k%f
        answer.append(arr.pop(idx))
        n-=1
    return answer