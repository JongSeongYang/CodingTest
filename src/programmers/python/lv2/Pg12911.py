# 다음 큰 숫자

def solution(n):
    answer = 0
    cnt = bin(n)[2:].count('1')
    for i in range(n+1,10000000):
        if cnt == bin(i)[2:].count('1'):
            answer = i
            break
    return answer