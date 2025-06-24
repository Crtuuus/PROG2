# Python ukazi in funkcije potrebne za izpit PROG2

## Osnovni ukazi in konstrukti

* **Uvoz modulov**
  Uvozi knjižnico (modul), npr. matematične ali JSON funkcije.

  ```python
  import math   # uvoz matematičnih funkcij
  import json   # uvoz JSON obdelave
  ```

* **Definicija funkcij**
  Določi funkcijo z imenom in parametri, vrne rezultat z `return`.

  ```python
  def ime_funkcije(parametri):   # začne definicijo funkcije
      # telo funkcije           # izvajajo se ukazi znotraj funkcije
      return vrednost           # vrnitev vrednosti klicatelju
  ```

* **Pogojni stavki**
  Izvede se prva resnična veja.

  ```python
  if pogoj:                     # če je pogoj resničen
      ...                       # izvede se ta blok
  elif drug_pogoj:              # sicer, če je drug pogoj resničen
      ...                       # izvede se ta blok
  else:                         # če noben pogoj ni resničen
      ...                       # izvede se ta blok
  ```

* **For zanka**
  Iteracija prek elementov v seznamu, nizu, množici ipd.

  ```python
  for x in iterable:            # za vsak element v iterable
      ...                       # izvede se ta blok
  ```

* **While zanka**
  Izvaja se, dokler je pogoj resničen.

  ```python
  while pogoj:                  # dokler je pogoj True
      ...                       # izvede se ta blok
  ```

* **Kontekstni manager za datoteke**
  Samodejno odpre in zapre datoteko.

  ```python
  with open('datoteka.txt', 'r') as f:   # odpri datoteko v bralnem načinu
      vsebina = f.read()                # preberi celotno vsebino
  ```

* **Seznami, n-torke, slovarji, množice**
  Pogoste vgrajene strukture podatkov.

  ```python
  L = [1, 2, 3]       # seznam (mutable zaporedje)
  T = (1, 2, 3)       # n-torka (immutable zaporedje)
  D = {'a': 1, 'b': 2} # slovar (mapa ključ->vrednost)
  S = {1, 2, 3}       # množica (unikatni elementi)
  ```

* **Uporabne funkcije**
  Osnovni agregati in urejanje sekvenc.

  ```python
  len(x)                     # dolžina sekvence
  min(x)                     # najmanjši element
  max(x)                     # največji element
  sum(x)                     # vsota elementov
  sorted(x, key=..., reverse=...)  # vrne nov, urejen seznam
  x.sort()                   # uredi seznam na mestu
  ```

* **List in dict comprehensions**
  Hitri načini za izdelavo seznamov in slovarjev.

  ```python
  [x for x in L if x % 2 == 0]      # seznam sodih števil iz L
  {x: x*x for x in L}               # slovar z x->x²
  ```

* **Članstvo, enumerate, zip**
  Preverjanje članstva in združevanje/številčenje elementov.

  ```python
  if x in L:                        # preveri, ali je x v L
      ...
  for i, x in enumerate(L):         # i = indeks, x = element
      ...
  for a, b in zip(L1, L2):          # poveže elemente dveh zaporedij
      ...
  ```

* **Lambda funkcije**
  Anonimne funkcije, pogosto kot `key`.

  ```python
  key_func = lambda a, b: a + b     # funkcija seštevanja dveh argumentov
  ```

* **Ravnanje z izjemami**
  Obvladovanje napak z `try/except`.

  ```python
  try:                              # poskusi izvajanje
      ...
  except Exception as e:            # ujame izjemo tipa Exception
      ...                            # obdelaj napako
  else:                             # če ni bilo napake
      ...
  finally:                          # vedno se izvede
      ...
  ```

## Pogosti ukazi v izpitnih nalogah

1. **Generiranje naključnih števil**
   Ustvarjanje naključnih vrednosti.

   ```python
   import random                   # modul za naključnost
   random.randint(a, b)            # celo število v [a,b]
   random.random()                 # realno število v [0.0,1.0)
   random.choice(seznam)           # naključni element iz seznama
   random.sample(range(a, b), k)   # k različnih elementov iz intervala
   ```

2. **Top-k elementov (heapq)**
   Dobi največje ali najmanjše elemente brez popolne ureditve.

   ```python
   import heapq                    # modul za kopice
   heapq.nlargest(8, iterable)     # 8 največjih elementov
   heapq.nsmallest(5, iterable)    # 5 najmanjših elementov
   ```

3. **HTTP zahteve (requests)**
   Pridobivanje spletnih vsebin kot besedilo ali JSON.

   ```python
   import requests                 # HTTP knjižnica
   html = requests.get(url).text   # pridobi HTML kot niz
   data = requests.get(url).json() # pridobi JSON kot Python objekt
   ```

4. **Regularni izrazi (re)**
   Iskanje in zamenjava vzorcev v besedilu.

   ```python
   import re                       # modul za regex
   re.findall(r'pattern', besedilo)  # vrne seznam vseh ujemanj
   re.search(r'pattern', besedilo)    # prvo ujemanje ali None
   re.sub(r'old', 'new', besedilo)    # zamenja vse "old" z "new"
   ```

5. **Risanje grafov (matplotlib)**
   Vizualizacija podatkov z različnimi tipi grafov.

   ```python
   import matplotlib.pyplot as plt  # modul za grafiko
   plt.plot(x, y)                  # črtni graf
   plt.hist(podatki, bins=...)     # histogram
   plt.scatter(x, y)               # raztresni diagram
   plt.xlabel('...')               # oznaka x-osi
   plt.ylabel('...')               # oznaka y-osi
   plt.title('...')                # naslov grafa
   plt.savefig('graf.png')         # shrani sliko grafa
   plt.close()                     # zapre figuro
   ```

6. **Obdelava slik (PIL + NumPy)**
   Branje, manipulacija in shranjevanje slik.

   ```python
   from PIL import Image            # knjižnica Pillow
   import numpy as np               # modul za številke

   img = Image.open('slika.png')    # odpri sliko
   arr = np.array(img)              # pretvori sliko v matriko
   # obdelava                       # različne operacije na arr
   new_img = Image.fromarray(arr)   # ustvari novo sliko iz matrike
   new_img.save('nova_slika.png')   # shrani sliko
   ```

7. **JSON obdelava**
   Pretvorba med nizi in Python strukturami.

   ```python
   import json                     # modul za JSON
   obj = json.loads(json_string)    # iz niza v Python strukturo
   s = json.dumps(obj, indent=2)    # iz strukture v čitljiv JSON
   ```

8. **Štetje pojavitev (Counter)**
   Štetje elementov in iskanje najpogostejših.

   ```python
   from collections import Counter  # modul za števce
   cnt = Counter(seznam)            # ustvari števec elementov
   cnt.most_common(15)              # 15 najpogostejših parov (element, št.)
   ```

9. **Dinamično programiranje**
   Primer: Fibonacci zaporedje.

   ```python
   F = [0, 1]                       # začetni pogoji
   for i in range(2, 100):          # od 2 do 99
       F.append(F[i-1] + F[i-2])    # doda vsoto dveh prejšnjih
   ```

10. **Operatorji v razredih**
    Definicija matematičnih operacij za razrede.

    ```python
    class Meritev:                  # razred za meritve z negotovostjo
        def __init__(self, a, da=0):# konstruktor sprejme vrednost in negotovost
            self.a, self.da = a, da
        def __add__(self, other):   # definicija operatorja +
            return Meritev(self.a+other.a, self.da+other.da)
    ```

11. **Branje CSV/TSV**
    Preprosto branje tabel z ločili.

    ```python
    with open('datoteka.tsv') as f:  # odpri datoteko TSV
        for line in f:               # preberi vsako vrstico
            cols = line.strip().split('\t')  # razdeli stolpce
    ```

12. **Monte Carlo za π**
    Aproksimacija števila π z naključnimi točkami.

    ```python
    import math, random             # modul za matematiko in naključje
    št_notri = sum(1 for _ in range(n)
                   if math.hypot(random.random()*2-1,
                                 random.random()*2-1) <= 1)  # šteje točke znotraj kroga
    pi = 4 * št_notri / n            # formula za π
    ```

---

# Java ukazi in funkcije potrebne za izpit PROG2

## Osnovni ukazi in konstrukti

* **Paketi in uvoz**
  Določanje paketa in uvažanje razredov iz drugih paketov.

  ```java
  package com.example;                          // določi paket trenutne datoteke
  import java.util.List;                        // uvozi List iz java.util
  import java.io.BufferedReader;                // uvoz za branje datotek
  import java.awt.Color;                        // uvoz za delo z barvami v GUI
  ```

* **Komentarji**
  Dodajanje pojasnil v kodo.

  ```java
  /** Javadoc komentar */                       // dokumentacijski komentar
  // enovrstični komentar                      // pojasnitev naslednje vrstice
  /* večvrstični komentar */                   // lahko zavzame več vrstic
  ```

* **Definicija razreda**
  Ustvarjanje novega razreda z lastnimi polji in metodami.

  ```java
  public class ImeRazreda {                     // začetk   public class ImeRazreda {                     // začetk\xa0razreda
      private int polje;                        // polje v razredu
      public ImeRazreda(int polje) {            // konstruktor
          this.polje = polje;                  // inicializacija polja
      }
  }
  ```

* **Metode in overloading**
  Definicija funkcionalnosti znotraj razreda; omogoča različne parametre.

  ```java
  public returnType imeMetode(parametri) {     // definicija metode
      // telo metode                           // logika metode
      return vrednost;                        // vrni rezultat
  }
  public static void method(int x, double y) {  // preobremenjena metoda
      System.out.println("x*y = " + x*y);    // izpis proizvoda
  }
  static void method(int x) {                   // preusmeritev na drugo obliko
      method(x, 2.0);
  }
  ```

* **Varijable in tipi**
  Deklaracija in inicializacija spremenljivk različnih tipov.

  ```java
  int x = 1;                                    // celo število
  double y = 1.23 * 9;                          // realno število
  char ch = 'a';                                // znak
  String str = "niz znakov";                 // niz znakov
  boolean b = x > 1;                            // logična vrednost
  final float G = 9.81f;                        // konstanta
  ```

* **Pretvorbe tipov (casting)**
  Sprememba tipa vrednosti.

  ```java
  int z = (int)y;                               // pretvori v celo število
  double w = (double)x;                         // pretvori v double
  z = Integer.parseInt("7");                  // iz niza v int
  w = Double.parseDouble("1.23");             // iz niza v double
  ```

* **String operacije**
  Združevanje in formatiranje nizi.

  ```java
  str = "w = " + w;                           // konkatenacija niza
  str = String.format("w = %.3f", w);          // oblikovano izpisovanje
  ```

* **Aritmetični operatorji**
  Osnovne matematične operacije.

  ```java
  System.out.println(x + y * z / w);             // seštevanje, množenje, deljenje
  System.out.println(x % z);                     // ostanek pri deljenju
  System.out.println(Math.pow(y, 2.0));          // potenciranje
  System.out.println(42.0 * Math.random());      // naključno število iz [0,42)
  System.out.println((int)(3.0 * Math.random())); // naključni 0,1 ali 2
  ```

* **Pogojni stavki**
  Veje kode glede na pogoje, vključno s ternarnim izrazom.

  ```java
  if (x < 1) { System.out.println("x < 1"); }  // preizkus enostavnega pogoja
  else if (x < 2) System.out.println("1 <= x < 2"); // brez oklepajev
  else { System.out.println("x >= 2"); }
  // ternarni operator
  System.out.println("x je " + (x < 1? "manjši": "večji") + " od 1");
  ```

* **Logični operatorji**
  Zloženi pogoji.

  ```java
  if (x == 1 || x == 2) System.out.println("x == 1 ali x == 2");
  if (x == 1 && x == 2) System.out.println("nemogoče");
  if (x != 1 && x != 2) System.out.println("x ni 1 ali 2");
  ```

* **Switch stavki**
  Večveščinsko razvejanje na podlagi vrednosti.

  ```java
  switch (x) {
    case 1: System.out.println("x == 1"); break;
    case 2: System.out.println("x == 2"); break;
    default: System.out.println("drugo"); break;
  }
  switch (ch) { case 'a': System.out.println("ch == 'a'"); break; default: System.out.println("ch != 'a'"); }
  ```

* **Zanke**

  ```java
  for (int i = 0; i < 3; i++)                              // tradicionalna for
      System.out.println(i);
  int ind = 0;
  while (ind < 3) { System.out.println(ind); ind++; }     // while
  for (String arg: args) System.out.println(arg);          // enhanced for
  ```

* **Seznami in zbirke**
  Dinamične strukture podatkov in operacije.

  ```java
  List<Double> list = new ArrayList<>(); list.add(1.0); list.add(0, 1.1); list.set(0, 0.9); list.size(); list.get(1); list.remove(0);
  Collections.sort(list); Collections.sort(list, Comparator.reverseOrder());
  Set<Double> set = new HashSet<>(); set.addAll(list); set.contains(1.0); set.remove(1.0);
  Map<String, Integer> map = new HashMap<>(); map.put("foo",0); map.get("foo"); map.containsKey("bar"); map.remove("baz");
  ```

* **File IO**
  Branje in pisanje datotek z BufferedReader/Writer.

  ```java
  try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
      String line;
      while ((line = br.readLine()) != null) System.out.println(line);
  } catch (IOException e) { e.printStackTrace(); }
  try (BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"))) {
      bw.write("tekst"); bw.newLine(); bw.flush();
  } catch (IOException e) { e.printStackTrace(); }
  ```

* **Razširjanje razredov in vmesniki**

  ```java
  class XYZ extends XY { /* dedovanje */ }
  if (obj instanceof XY) { XY xy = (XY)obj; }
  interface Printable { void print(); }
  class Point implements Printable { public void print() { System.out.println(toString()); } }
  ```

* **Generiranje naključnih simbolov**

  ```java
  Random rnd = new Random();                 // razred za naključnost
  char c = SYMBOLS.charAt(rnd.nextInt(SYMBOLS.length())); // izberi naključni znak
  ```

* **Grafični vmesniki (Swing/AWT)**

  ```java
  JFrame frame = new JFrame("Naslov");       // okno
  JPanel panel = new JPanel();                 // panel
  JButton btn = new JButton("Klikni");      // gumb
  frame.add(panel); frame.add(btn);
  frame.pack(); frame.setVisible(true);        // prikaži okno
  ```

---

*Uporabite te ukaze in konstrukte kot izhodišče za reševanje PROG2 izpitnih nalog v Javi.*
