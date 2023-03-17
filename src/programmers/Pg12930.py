# 이상한 문자 만들기

def solution(s):
    answer = ''
    split = s.split(" ")
    for i in range(len(split)):
        new_string =''
        for j in range(len(split[i])):
            if j%2 ==0: # 짝수면
                new_string += split[i][j].upper()
            else:
                new_string += split[i][j].lower()
        split[i] = new_string
    return ' '.join(split)