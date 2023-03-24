# 최대공약수와 최소공배수

from math import gcd

def solution(n, m):
    answer = []
    answer.append(gcd(n,m))
    answer.append(n * m // gcd(n, m))
    return answer