# 옹알이 (2)

def solution(babbling):
    can_speak = ['aya', 'ye', 'woo', 'ma']
    answer = 0
    for b in babbling:
        for cs in can_speak:
            if cs*2 not in b:
                b = b.replace(cs,' ')
        if len(b.strip())==0:
            answer+=1
    return answer