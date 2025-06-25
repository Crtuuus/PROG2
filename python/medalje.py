import requests
import json
import matplotlib.pyplot as plt

def fetch_medals(url):
    """
    Pošlje GET zahtevo na podani URL in vrne JSON kot Python slovar.
    """
    resp = requests.get(url)
    resp.raise_for_status()
    return resp.json()

def compute_metrics(data):
    """
    Iz izvornega slovarja data (država → {gold, silver, bronze, population})
    izračuna:
      - total_medals: skupno število medalj po državi
      - medals_per_million: medalje na milijon prebivalcev
    Vrne dva slovarja.
    """
    total_medals = {}
    medals_per_million = {}
    for country, stats in data.items():
        total = stats['gold'] + stats['silver'] + stats['bronze']
        total_medals[country] = total
        per_mil = total / (stats['population'] / 1_000_000)
        medals_per_million[country] = per_mil
    return total_medals, medals_per_million

def top_n(d, n=10):
    """
    Vrne seznam n parov (država, vrednost) največjih vrednosti v slovarju d.
    """
    return sorted(d.items(), key=lambda kv: kv[1], reverse=True)[:n]

def plot_two_charts(total_medals, medals_per_million, n=10, output_path='medals.png'):
    """
    Ustvari sliko z dvema horizontalnima stolpčnima diagramoma:
      - levo: skupno število medalj
      - desno: medalje na milijon prebivalcev (log-x os)
    in shrani na output_path.
    """
    top_tot = top_n(total_medals, n)
    top_pm  = top_n(medals_per_million, n)

    countries_tot, totals = zip(*top_tot)
    countries_pm, values_pm = zip(*top_pm)

    fig, (ax1, ax2) = plt.subplots(1, 2, figsize=(14, 6))

    # Levi graf: skupno število medalj
    ax1.barh(countries_tot, totals)
    ax1.set_xlabel('Skupno število medalj')
    ax1.set_ylabel('Država')
    ax1.set_title(f'Top {n} držav po skupnem številu medalj')
    ax1.invert_yaxis()  # največji zgoraj

    # Desni graf: medalje na milijon prebivalcev, log-x os
    ax2.barh(countries_pm, values_pm, log=True)
    ax2.set_xlabel('Medalje na milijon prebivalcev (log scale)')
    ax2.set_ylabel('Država')
    ax2.set_title(f'Top {n} držav po medaljah na milijon prebivalcev')
    ax2.invert_yaxis()

    fig.tight_layout()
    fig.savefig(output_path, dpi=300)
    print(f'Ustvarjena slika: {output_path}')

if __name__ == '__main__':
    # Zamenjaj URL z dejansko potjo do JSON-ja
    url = 'https://tvoj-streznik.example.com/medals.json'
    data = fetch_medals(url)
    total, per_mil = compute_metrics(data)
    plot_two_charts(total, per_mil, n=10, output_path='medals.png')
