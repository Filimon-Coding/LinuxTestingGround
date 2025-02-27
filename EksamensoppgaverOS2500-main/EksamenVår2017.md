# Eksamen 2017

# PROSESSER

## 1(a)
## Forklar hva som menes med PID.

<br>

### **PID er et akronym for process identification number på et linux eller et unix basert system. PID blir automatisk tildelt til hver prosess når den start.**

---

<br>
<br>


## 1(b)
## Forklar kort hva et systemkall er.

<br>

### **Et system kall er når brukerprogrammer trenger hjelp fra OS-kjernen.**

---

<br>
<br>

## 1(c)
## Du utfører Linux-kommandoen ls /etc/passwd. Forklar kort om dette vil medføre at det utføres systemkall og isåfall hvorfor dette er nødvendig.

<br>

### **Kommandoen ls innholder systemkallet readdir() som ber kjernen om å lese hva en katalog inneholder.**

---
<br>
<br>

## 1(d)
## Om man kopierer et C-program kompilert på en x86-basert Linux maskin til en x86-basert Mac OS X, vil davil da programmet kunne kjøre? Forklar kort.

<br>

### **Nei. Selv om Linux og mac bruker et Unix basert system så vil ikke dette fungere. a.out som vi får når vi kompilerer c programmet vil inneholde spesielle systemkall som er helt spesifikke for Linux og som andre OS ikke forstår. Selvom det er et intel cpu med x86 instruksjoner så er det to helt forskjellige OS**

---
<br>
<br>

## 1(e)
## Anta at man kompilerer et Java-program på en x86-basert Linux maskin slik at man får en Java class-fil. Om man kopierer class-filen til en x86-basert Windows 10 PC, vil da programmet kunne kjøre? Er det noen forutsetninger utover det som operativsystemet bidrar med som må være på plass for at programmet skal kunne kjøre? Forklar kort.

<br>

### **Hvis java versjonene på de to OS`ene er like vil dette fungere. Java er ikke bakoverkompatilbelt så hvis Linux maskinen har et nyere java versjon enn windows maskinen så vil ikke dette fungere. Men derimot hvis de har like java versjoner så vil dette fungere fint. Siden Java bruker JVM så skal det heller ikke spille noen rolle hvilken cpu de to maskinene bruker.** 

---

<br><br>

## 1(f)
## En prosess bruker ca 8 minutter på å beregne et CPU-intensivt regnestykke. Hvis to slike prosesser kjører samtidig på et multitasking OS med én CPU, hvor lang tid vil det omtrent ta? Forklar kort.

<br>

### **Her vil det brukes 16 minutter på å bli ferdig med prosessene. OS cheduleren bytter likt mellom prosessene så dem omtrent får lik cpu tid**

---

<br><br>

## 1(g)
## Hvorfor kan ikke et OS generelt sett utnytte en dual core CPU ved å la en vanlig sekvensiell prosess kjøre på to CPUer? Forklar kort.

<br>

### **Fordi OS ikke kjennder den indre logikken i prosesseene og må la instruksjonene kjøres sekvensielt. Instruksjonene kan ikke kjøres parallelt, for det kan være at de avhenger av hverandre.** 
---
<br><br>

## 1(h)
### **En sekvensiell 100% CPU-intensiv regnejobb bruker 6 minutter på en dual core CPU. Hvor lang tid tar det hvis 7 slike program startes samtidig på samme maskin? Forklar kort.**

<br>

### **21 minutter / Mitt regnestykke 6 * 7 / 2** 

<br>

## Løsningsforslag
### **Ca 21 minutter. OS vil fordele CPU jevnt mellom de 7, de f ̊ar da 2/7 deler CPU-tid hver og 2/7 deler av 21 minutter er 6 minutter. Alternativt: det er 7 · 6 = 42 minutter CPU-tid som trengs for  ̊a bli ferdig. Hver CPU bidrar like mye og det tar 42/2 = 21 minutter.**

---

<br><br>

# LINUX KOMMANDOLINJE

## 2(a)
## I de følgende deloppgavene skal vi først studere noen Linux-kommandoer som til slutt skal settes sammen til en lang Linux-kommando som viser hvilke fem ord Shakespeare brukte oftest i sine samlede verker.

## Forklar utifra følgende eksempel hva kommandoen head -n 2 gjør:

```bash
    $ cat num.txt 30 to
    20 en
    200 tre
    $ head -n 2 num.txt 30 to
    20 en
```

<br>

# Svar

### **Kommandoen head brukes til å spesifisere hvor mange linjer av et dokument du ønsker skrevet ut. med -n opsjonen og antall kan man eksplisitt be om antall linjer fra toppen og nedover i dokumentet.**
---
<br> <br>

## 2(b)
## Vi bruker så kommandoen sort på den samme filen num.txt. Forklar utifra følgende eksempel hva opsjonene n og r betyr for kommandoen sort

```bash
$ sort num.txt 
200 tre
20 en
30 to

$ sort -n num.txt 
20 en
30 to
200 tre

$ sort -nr num.txt 
200 tre
30 to
20 en
```
<br>

# Svar
## **Hvis man bruker kun sort så sorteres alt innhold alfabetisk.**
## **sort -n sorterer nummerisk**
## **sort -nr sorterer nummerisk reverse**

---

<br><br>

## 2(c)
## Studer manualsiden for kommandoen uniq:

```bash
NAME
uniq - remove duplicate lines from a sorted file
SYNOPSIS
uniq [OPTION]... [INPUT [OUTPUT]]
DESCRIPTION
Discard all but one of successive identical lines from INPUT (or standard input), writing to OUTPUT (or standard output).
-c, --count
prefix lines by the number of occurrences
-d, --repeated
only print duplicate lines
-D, --all-repeated
only print all duplicate lines
-f, --skip-fields=N
avoid comparing the first N fields
-t, --separator=SEP
use SEParator to delimit fields
-u, --unique
only print unique lines
-W, --check-fields=N
compare no more than N fields in lines
```

## Gitt at du har følgende fil med navn test.txt
```bash
to 
en 
en 
to 
to
```

## Angi hvordan du kan bruke uniq med opsjoner på filen test.txt slik at output blir
```bash
1 to 
2 en 
2 to
```

<br>

# Svar

```bash
uniq -c test.txt
```

---

<br><br>

### Lag så en sammensatt kommando med sort og uniq og opsjoner, slik at du får en numerisk sortert liste overantall ganger ord forekommer i filen test.txt:

```bash
$ cat test.txt | DIN KOMMANDO 
3 to
2 en
```

Angi hva som må stå istedet for DIN KOMMANDO.

<br>

# Svar

```bash
cat test.txt | sort -nr  | uniq -c
    3 to
    2 en
```

---

<br><br>

## 2(e)
## Anta du står i en katalog med fire underkataloger som inneholder tekstversjonen av alle Shakespeares verker og som ser slik ut når du lister dem:

```bash
$ ls -l
totalt 4
drwx------ 2 haugerud drift 512 2016-11-21 15:32 comedies drwx------ 2 haugerud drift 512 2016-11-21 15:32 histories drwx------ 2 haugerud drift 512 2016-11-21 15:32 poetry
drwx------ 2 haugerud drift 512 2016-11-21 15:32 tragedies
$ ls -l poetry/
totalt 265
-rw------- 1 haugerud drift 14366 2016-08-29 07:45 loverscomplaint -rw------- 1 haugerud drift 84700 2016-08-29 07:46 rapeoflucrece -rw------- 1 haugerud drift 95662 2016-08-29 07:43 sonnets -rw------- 1 haugerud drift 18954 2016-08-29 07:46 various
-rw------- 1 haugerud drift 54390 2016-08-29 07:46 venusandadonis
```

<br>

# Svar

```bash
cat */* >> /tmp/alle.txt Resultatet blir det samme med enkel > . 

Andre altertativer:

for file in $(find . -type f); do cat "$file" >> /tmp/alle.txt ; done;

find . -type f -name "*" -exec cat {} >> /tmp/alle.txt \;

```

---
<br>
<br>

## 2(f)
## Linux-kommandoen tr leser fra standard input og kan brukes til å skifte ut tegn i tekster. Følgende kommando bytter ut alle sekvenser av tegn som ikke er bokstaver med ett linjeskift:

```bash
$ echo "Hei, ja   og Hallo dere..." | tr -cs A-Za-z '\n'
Hei
ja
og
Hallo dere
```

## Dermed overføres en setning til ord fordelt linje for linje. Kommandoen tr kan også brukes til å bytte store bokstaver med små

```bash
$ echo "HEisaNN" | tr A-Z a-z 
heisann
```

## Lag en sammensatt kommando som gjør begge deler ved å fylle inn det som mangler i kommandoen nedenfor, slik at resultatet blir som angitt:

```bash
$ echo "Hei, ja og Hallo dere..." | DIN KOMMANDO
hei
ja
og
hallo dere
```

<br>

# Svar
```bash
echo "Hei, ja   og Hallo dere..." | tr -cs A-Za-z '\n' | tr A-Z a-z

hei
ja
og
hallo
dere

```
---
<br><br>


## 2(g)
## Bruk det du har lært fra de tidligere deloppgavene og filen /tmp/alle.txt fra deloppgaven 2(e) til å lage en enlinjers Linux-kommando som lager en liste over de 5 ordene som Shakespeare brukte mest når han skrev sine verker. Output fra kommandoen skal være på formen

    29854 the 
    27554 and 
    23357 i 
    21075 to 
    18520 of

## eller ihvertfall inneholde samme informasjon. Resultatet betyr at Shakespeare brukte ordet "the" 29854 ganger og "and" 27554 ganger.

<br>

# Svar

```bash
cat /tmp/alle.txt | sort -nr | uniq -c
```
---
<br>
<br>

# Bash-scripting

## 3
## Skriv et bash-script rename.sh som endrer filendelse på filer i katalogen det kjøres. Brukeren angir en filendelse og hva den skal endres til med to argumenter. Hvis man bruker rename.sh som følger

```bash
$ rename.sh wav mp3 
Endrer fil.wav til fil.mp3 
Endrer fil2.wav til fil2.mp3
```

## skal alle filer i katalogen som har filendelse wav endres til mp3. En opplysning om hver endring skal gis som i eksempelet. Du trenger ikke å sjekke at brukeren virkelig kjører scriptet med to argumenter.

## Man kan bruke kommandoen basename i scriptet om man ønsker det; to relevante eksempler er vist her:

```bash

$ basename fil.wav .wav
fil
$ basename fil.12.wav .wav fil.12
```

# Svar

```bash
#! /bin/bash
fra=$1
til=$2
for fil in *.$fra
do
   if [ -f $fil ]
   then
      name=$(basename $fil .$fra)
      mv $fil $name.$til
      echo "Endrer $fil til $name.$til"
fi done
```
---

<br><br>

# Virtualisering

## 4(a)
## Beskriv og forklar kort to grunner til at virtualisering av en datamaskin er nyttig, sammenlignet med å bruke en tradisjonell datamaskin.

<br>

# Svar

### **Hoved grunnene er Isolasjon, Ressurssparing, Fleksibilitet, Programvare-utvikling, Skytjenester

### **Isolasjon**
* Tjenester og programmer kan kjøre på hver sin dedikerte server
* Unngår at de forskjellige tjenestene ødelegger for hverandre og gir ryddigere drift
* Men hva om den fysiske serveren eller hypervisor feiler?
* Det meste av nedetid og feil skyldes ikke hardware men software. Og software for en hypervisor er generelt mindre kompleks enn all programvaren på en hel maskin
* Sikkerhet: hvis en tjeneste blir hacket, vil det ikke påvirke de andre tjenestene
* Dette er fordi Operativsystemet og applikasjonene kun kommuniserer mot det virtuelle hardware-API'et som hypervisor gir dem tilgang til. De har ingen mulighet til å kommunisere med andre deler av en hypervisor eller andre VMer.

### **Ressurssparing**

* Man kan oppnå isolasjon ved å ha en fysisk server for hver tjeneste, men det gir store driftskostnader
* Med virtualisering kan det samme oppnås på en enkelt server
* Virtuelle maskiner (VMer) som for eksempel bruker lite CPU kan settes på samme fysiske server
* VMer kan enkelt flyttes til og fra fysiske servere og man kan dermed spare hardware og strøm

### **Fleksibilitet**

* Kapasiteten kan enkelt økes ved å legge til flere VMer, lastbalansering blir enklere
* Elastisitet: Man kan dynamisk tildele CPUer og internminne til VMer
Har en VM blitt ødelagt eller kompromittert kan man enkelt starte opp en ny kopi
* Tradisjonelt er det arbeidskrevende å flytte en tjeneste eller et softwareprosjekt til en ny server på grunn av avhengighet av operativsystemet og annen programvare: når noe er utviklet på en VM så kan hele VMen flyttes eller kopieres
* Live migration: Hele VM flyttes til annen fysisk server uten nedetid på tjenestene

---
<br><br>

## 4(b)
## Inntil 2005 var det slik at det fantes noen x86 instruksjoner (som for eksempel POPF) som bare ble oversett om de ble utført i user mode. Det disse instruksjonene utførte skulle bare være lov å gjøre i kernel mode og ingen ting skjedde når de ble utført i user mode. Forklar kort hva som gjorde dette problematisk i forbindelse med virtualisering og hvordan disse hardware-instruksjonene ble endret for å støtte x86-virtualisering.

<br>

# Svar
### **Gjeste OS kjører i user mode og vil ikke fungere som på vanlig hardvare om en slik instruksjon droppes. Det vil føre til uforutsigbar oppførsel og kan føre til at OS crasher i verste fall. Disse sensitive intruksjonene ble endret slik at de trap`er til kernel mode  når de utføres i user mode, istedet for å ikke gjøre noe**

---
<br><br>

## 4(c)
## Forklar kort hva som ligger i begrepet Unikernel.

<br>

# Svar

### **En Unikernel er en minimalistisk operativsystemkjerne som også inneholder selve tjenesten eller applikasjonen som skal kjøres. Inneholder typisk kun akkurat det som er nødvendig for at tjenesten som skal tilbys kan kjøre.**

---
<br><br>

## 4(d)
## Ofte omtaler man et komplett operativsystem, som for eksempel Ubuntu, som unødvendig stort når det skal være operativsystem i en virtuell maskin. Forklar kort årsaker til det og hvordan dette er relevant for Unikernels.

<br>

# Svar

### **Et generelt operativsystem er laget for  ̊a kunne kjøre p ̊a mange forskjellige typer hardware og har et komplekst grensesnitt mot denne hardwaren. Et OS i en virtuell maskin opererer mot et vesentlig enklere grenesesnitt, hypervisors virtualisering av hardware. Dermed er det mye kode i et generelt OS som er overflødig. I tillegg har hypervisor allerede en form for OS-kjerne som for eksempel sørger for scheduling og virtuelt minne. Et OS for en virtuell maskin kan dermed klare seg uten mye av koden et generelt OS trenger og det er nettopp dette som utnyttes i en Unikernel. Kun det som er nødvendig for at tjenesten skal virke er tatt med.**

---

<br><br>

# POWERSHELL

