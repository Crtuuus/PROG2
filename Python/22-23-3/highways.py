import requests
URL = "https://lovro.fri.uni-lj.si/pro2/exams/highways.net"

vrstice = requests.get(URL).text.splitlines()

# 1) preberi N iz prve vrstice
vertices = int(vrstice[0].split(None, 1)[1])

slovar = {}
# 2) preberi naslednjih N vrstic z vrhovi
for i in range(vertices):  # <-- prej je iteriralo po znakih niza
    id_str, ime = vrstice[i+1].split(None, 1)  # ime je lahko z razmaki
    id = int(id_str)
    ime = ime.strip().strip('"')               # odstrani narekovaje
    slovar[id] = [ime, 0]

# 3) robovi se začnejo na indeksu vertices + 2 (po vrstici "*Edges")
edges = vertices + 2
for i in range(edges, len(vrstice)):
    if not vrstice[i].strip():
        continue
    toks = vrstice[i].split()
    if len(toks) < 2:
        continue
    prva, druga = int(toks[0]), int(toks[1])
    slovar[prva][1] += 1
    slovar[druga][1] += 1

po_stevilu_in_imenu = sorted(
    slovar.items(),
    key=lambda kv: (-kv[1][1], kv[1][0].casefold())
)

for _id, (ime, cnt) in po_stevilu_in_imenu[:10]:
    print(ime, cnt)
