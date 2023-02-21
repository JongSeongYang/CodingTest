# 더 맵게

def solution(scoville, K):
    answer = 0
    while scoville[0]<K:
        scoville.sort()
        new_s = scoville[0] + scoville[1] * 2
        answer += 1
        new_box = scoville[2:]
        new_box.append(new_s)
        new_box.sort()

        scoville = new_box
    return answer