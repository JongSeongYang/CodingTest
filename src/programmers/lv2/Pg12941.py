# 최솟값 만들기

def solution(A,B):
    answer = 0
    for a,b in zip(A.sort(),B.sort(reverse=True)):
        answer+=a*b
    return answer