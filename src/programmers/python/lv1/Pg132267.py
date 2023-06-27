# 콜라 문제

def solution(a, b, n):
    answer = 0

    while n >= a:
        div = n // a
        remain = n % a
        answer += b * div
        n = b * div + remain

    return answer