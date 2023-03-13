# 수박수박수박수박수박수?

def solution(n):
    answer = ''

    pattern_1 = "수박"
    pattern_2 = "수"
    num_1 = n // 2
    num_2 = n % 2

    for i in range(num_1):
        answer += pattern_1
    if num_2 != 0:
        answer += pattern_2

    return answer