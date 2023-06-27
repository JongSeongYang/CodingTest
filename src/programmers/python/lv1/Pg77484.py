# 로또의 최고 순위와 최저 순위

def solution(lottos, win_nums):
    answer = []
    same = 0
    zero = 0
    for i in range(len(lottos)):
        if lottos[i] in win_nums:
            same += 1
        elif lottos[i] == 0:
            zero += 1
    answer.append(same + zero)
    answer.append(same)
    for i in range(2):
        if answer[i] >= 2:
            answer[i] = 7 - answer[i]
        else:
            answer[i] = 6

    return answer