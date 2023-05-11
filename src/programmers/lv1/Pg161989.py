# 덧칠하기

def solution(n, m, section):
    answer = 0
    s = 0
    last = 0
    for i in section:
        if i <= last: # 이미 칠했기 때문에 pass
            continue
        else:
            if i+m-1>n: # 벽의 크기를 벗어나게되면
                last = n # 벽의 마지막까지만 칠하도록
                s = n-m+1
            else:
                s = i
                last = i+m-1
            answer+=1
    return answer