import requests
from collections import Counter
from itertools import combinations
movies = requests.get("https://lovro.fri.uni-lj.si/pro2/exams/movies").json()
counts = Counter(
    tuple(sorted((a.strip(), b.strip())))
    for m in movies
    for a, b in combinations(m["actors"].split(","), 2)
)
(x, y), n = counts.most_common(1)[0]
print(f"{x} & {y} ({n} movies)")
