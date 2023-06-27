# 두 개 뽑아서 더하기

from itertools import combinations

def solution(numbers):
    answer = []
    result = combinations(numbers, 2)
    for i in result:
        sum_result = i[0]+i[1]
        if sum_result not in answer:
            answer.append(sum_result)
    return sorted(answer)