# 하샤드의 수

def solution(x):
    list_x = list(str(x))
    sum_x = 0
    for i in list_x:
        sum_x+=int(i)
    if x % sum_x==0:
        return True
    return False