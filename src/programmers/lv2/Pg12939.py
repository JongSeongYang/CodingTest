# 최댓값과 최솟값

def solution(s):
    answer = ''
    arr = list(map(int, s.split(' ')))
    answer = answer + str(min(arr)) + ' ' + str(max(arr))
    return answer