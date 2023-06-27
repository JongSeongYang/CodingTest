# 푸드 파이트 대회

def solution(food):
    answer = ''
    for i in range(1, len(food)):
        for j in range(food[i] // 2):
            answer += str(i)
    tmp_answer = list(answer)
    tmp_answer.reverse()
    reverse_answer = ''.join(tmp_answer)

    return answer + '0' + reverse_answer