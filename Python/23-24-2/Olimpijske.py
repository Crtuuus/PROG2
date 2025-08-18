import requests
import matplotlib.pyplot as plt

# Prenesi podatke
url = "https://lovro.fri.uni-lj.si/pro2/exams/paris24"
data = requests.get(url).json()

# Izračunaj skupno število medalj in na milijon preb.
results = []
for country, d in data.items():
    total = d["gold"] + d["silver"] + d["bronze"]
    per_million = total / (d["population"] / 1_000_000)
    results.append((country, total, per_million))

# Uredi po skupnem št. medalj in po medaljah na mio. prebivalcev
top_total = sorted(results, key=lambda x: x[1], reverse=True)[:20]
top_per_mil = sorted(results, key=lambda x: x[2], reverse=True)[:20]

# Pripravi grafa z obratnim vrstnim redom (najboljši zgoraj)
fig, axs = plt.subplots(1, 2, figsize=(18, 8))

axs[0].barh(
    [x[0] for x in top_total][::-1],  # države
    [x[1] for x in top_total][::-1]   # medalje
)
axs[0].set_title("Število medalj")

axs[1].barh(
    [x[0] for x in top_per_mil][::-1],    # države
    [x[2] for x in top_per_mil][::-1],    # medalje/mio
    log=True
)
axs[1].set_title("Število medalj / milijon prebivalcev")


plt.tight_layout()
plt.savefig("paris24.pdf")
