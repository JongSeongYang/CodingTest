# 카드 뭉치

def solution(cards1, cards2, goal):
    answer = ''
    for i in range(len(goal)):
        if len(cards1) != 0 and goal[i] == cards1[0]:
            cards1.pop(0)
        elif len(cards2) != 0 and goal[i] == cards2[0]:
            cards2.pop(0)
        else:
            answer+='No'
            break
    if answer != 'No':
        answer+='Yes'
    return answer