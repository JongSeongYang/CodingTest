# 핸드폰 번호 가리기

def solution(phone_number):
    length = len(phone_number)
    answer = phone_number[length-4:]
    star = ''
    for i in range(length-4):
        star+='*'
    return star+answer