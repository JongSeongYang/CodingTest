# 점프와 순간 이동

def solution(n):
    answer = 0
    while n>0:
        if  n%2 == 0:
            n//=2
        else:
            answer += 1
            n//=2
    return answer