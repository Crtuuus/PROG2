import requests,itertools

data = requests.get('https://lovro.fri.uni-lj.si/pro2/exams/movies').json()
for genre in ("Action","Drama","Horror"):
    slovar_pojavljanja = {}
    for i in data:
        if genre in i['genres']:
            actors = sorted([a.strip() for a in i['actors'].split(',') if a.strip()])
            combinations = itertools.combinations(actors, 2)  # ni treba v list
            for j in combinations:
                if j not in slovar_pojavljanja:
                    slovar_pojavljanja[j] = 0
                slovar_pojavljanja[j] += 1
        največ_pojavitev = 0
        ključ = None
        for k, v in slovar_pojavljanja.items():
            if v > največ_pojavitev:
                največ_pojavitev = v
                ključ = k
    print(f"Najbolj pogosta kombinacija za {genre}: {ključ}, število pojavitev: {največ_pojavitev}")
