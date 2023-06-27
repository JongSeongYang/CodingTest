# 3진법 뒤집기

def solution(n):
    answer = 0
    three = change(n,3)
    answer = int(three,3)
    return answer


def change(n, q):
    rev_base = ''
    while n > 0:
        n, mod = divmod(n, q)
        rev_base += str(mod)
    return rev_base