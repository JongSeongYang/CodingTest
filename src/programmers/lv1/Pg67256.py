# 키패드 누르기

def solution(numbers, hand):
    answer = ''
    now_L = [3,0]
    now_R = [3,2]
    for i in range(len(numbers)):
        if numbers[i] in [1,4,7]:
            answer+="L"
            now_L = [(numbers[i]-1)//3, (numbers[i]-1)%3]
        elif numbers[i] in [3,6,9]:
            answer+="R"
            now_R = [(numbers[i]-1)//3, (numbers[i]-1)%3]
        else:
            a,now_L,now_R = distance(numbers[i],hand,now_L,now_R)
            answer+=a
    return answer

def distance(number, hand, now_L, now_R):
    num = number
    if number == 0:
        num = 11
    dis_L = abs((num-1)//3 - now_L[0]) + abs((num-1)%3 - now_L[1])
    dis_R = abs((num-1)//3 - now_R[0]) + abs((num-1)%3 - now_R[1])
    next_pos =[(num-1)//3, (num-1)%3]
    if dis_L < dis_R or (dis_L == dis_R and hand=="left"):
        return "L", next_pos, now_R
    elif dis_L > dis_R or (dis_L == dis_R and hand=="right"):
        return "R", now_L, next_pos