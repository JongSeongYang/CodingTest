# 개인정보 수집 유효기간

from dateutil.relativedelta import relativedelta
import datetime

def solution(today, terms, privacies):
    answer = []
    dic = {}
    t = datetime.datetime.strptime(today.replace('.', ''), '%Y%m%d')
    for i in range(len(terms)):
        term = terms[i].split(' ')
        dic[term[0]] = term[1]

    for i in range(len(privacies)):
        p = privacies[i].split(' ')
        dt = datetime.datetime.strptime(p[0].replace('.', ''), '%Y%m%d')
        if t >= dt + relativedelta(months=int(dic[p[1]])):
            answer.append(i + 1)
    return answer