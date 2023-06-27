# 소수 만들기

from itertools import combinations

def solution(nums):
    answer =0
    result = combinations(nums, 3)
    for i in result:
        sum_result = i[0]+i[1]+i[2]
        if check(sum_result):
            answer+=1
    return answer

def check(num):
    a = 0
    for i in range(1,int(num**0.5) +1):
        if num % i ==0:
            a+=1
    if a >1:
        return False
    else:
        return True