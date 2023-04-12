# 신규 아이디 추천

def solution(new_id):
    answer = ''
    # 1.
    new_id = new_id.lower()
    # 2.
    second_id =''
    for i in range(len(new_id)):
        if ('a' <= new_id[i] and new_id[i]<= 'z') or new_id[i] in ['-','_','.'] or ('0'<=new_id[i] and new_id[i]<='9'):
            second_id+=new_id[i]
    # 3.
    while '..' in second_id:
        second_id = second_id.replace('..','.')
    # 4.
    if second_id.startswith('.'):
        second_id = second_id[1:]
    if second_id.endswith('.'):
        second_id = second_id[:-1]
    # 5.
    if second_id == '':
        second_id +='a'
    # 6.
    if len(second_id) > 15:
        second_id = second_id[:15]
        if second_id.endswith('.'):
            second_id = second_id[:-1]
    # 7.
    if len(second_id) < 3:
        while len(second_id) < 3:
            second_id += second_id[len(second_id)-1]
    return second_id