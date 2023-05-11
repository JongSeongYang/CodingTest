# [1차] 다트 게임

def solution(dartResult):
    answer = 0
    score_arr = []
    now_idx = 0

    for i in range(len(dartResult)):
        if dartResult[i].isdecimal():  # 숫자인지 확인
            num = 0
            if dartResult[i + 1].isdecimal():  # 다음 문자도 숫자인지 확인
                num = int(dartResult[i:i + 2])  # 숫자라면 다음 문자까지 함께 점수로 적용
                i += 1  # 다음 문자 스킵
            else:
                num = int(dartResult[i])
            if dartResult[i + 1] == 'S':  # 점수 적용
                score_arr.append(num)
            elif dartResult[i + 1] == 'D':
                score_arr.append(num ** 2)
            else:
                score_arr.append(num ** 3)

        elif dartResult[i].isalpha():
            now_idx += 1  # 현재 점수 반영 완료했으므로 idx 증가
        else:
            if dartResult[i] == '*':
                if now_idx == 1:
                    score_arr[now_idx - 1] *= 2
                elif now_idx >= 2:
                    score_arr[now_idx - 1] *= 2
                    score_arr[now_idx - 2] *= 2
            else:
                score_arr[now_idx - 1] *= -1
    return sum(score_arr)