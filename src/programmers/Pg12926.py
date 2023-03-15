# 시저 암호

def solution(s, n):
    answer = ''
    for i in range(len(s)):
        if s[i] == ' ':
            answer+=' '
        else:
            if ord(s[i]) >=97:
                answer+=chr((ord(s[i])+n-97)%26+97)
            else:
                answer+=chr((ord(s[i])+n-65)%26+65)
    return answer