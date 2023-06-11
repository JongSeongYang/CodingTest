def solution(s):
    answer = ''
    arr = s.split(' ')
    for i in range(len(arr)):
        c = arr[i][:1]
        if c.isdigit():
            tmp =arr[i].lower()
            answer += ' '+tmp
        else:
            tmp =arr[i].lower()
            tmp = tmp.capitalize()
            answer += ' '+tmp
    return answer.lstrip()