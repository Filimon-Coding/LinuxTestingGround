# Eksamen 2019
## Datamaskinarkitektur
# 1
## Hvilken type logisk port er dette sannhetstabell for? A og B er input og UT er resultatet.


# Svar

    And

--- 
<br><br>

# 2
## Hva viser denne figuren?

<img src="/Users/aziz/Documents/GitHub/EksamensoppgaverOS2500/Skjermbilde 2022-05-10 kl. 13.29.44.png">

# Svar
    OR port
---
<br>
<br>

# 3
## Hva blir det logiske uttrykket F(A,B) for denne kretsen?

<img src="/Users/aziz/Documents/GitHub/EksamensoppgaverOS2500/Skjermbilde 2022-05-10 kl. 13.30.37.png">

# Svar
    A * B + ANOT * B
---
<br><br>

# 4
## Uttrykket for den samme kretsen som if forrige oppgave kan forenkles, utifra sannhetstabellen eller ved å bruke boolsk algebra. Hva kan uttrykket for F(A,B) forenkles til

<img src="/Users/aziz/Documents/GitHub/EksamensoppgaverOS2500/Skjermbilde 2022-05-10 kl. 13.31.38.png">

# Svar
    B
---
<br><br>


# 5
## Forklar kort hvorfor det er viktig og nødvendig å ha en klokke i en CPU, spesielt når resultatet fra beregninger skal mellomlagres. Bruk gjerne eksempelet fra forelesning der studenter simulerte D-låser i forklaringen.


# Svar
    For å kunne kontrollere nøyaktig når dataene blir overført og gjøre overføringen uavhengig av små svingninger i tempo på de involverte kretsene, innfører man en klokke som med jevne av og på singnaler styrer dette. 
--- 
<br><br>

# 6
## Forklar kort hvordan maskinkoden for assembly-instruksjonen
    add %rax,%rbx
## vil føre til at to tall legges sammen. Beskriv spesielt hvilken rolle instruksjonsdekoderen, registerne og ALU har når denne opperasjonen gjennomføres.

# Svar
    Denne instruksjonen adderer to tall som ligger i disse registrene. Selve operasjonene skjer i ALU. instruksjonsdekoderen sørger for at maskininstruksjonene virekelig fører til at alu legger sammen tallene. 
---

<br><br>

# Linux Kommandolinje
# 7
## Hvilken Linux-kommando lager en ny katalog?

## Svar

    mkdir

---
<br><br>

# 8

## Hvilken katalog referer .. (to punktum) til i et bash-shell?

## Svar

    Mappen over den du står i

---
<br><br>

# 9

## Hva blir output av bash-kommandoen
echo "hei du der" | sort | grep du

## Svar

    hei du der

---
<br><br>

# 10
## Den 21 april 2019 kl 22.00 om kvelden utfører du på en Linux-server følgende kommando:
    $ find /home/hh/div -type d -newermt "21 Apr 2019 00:00" -ls
    2623843 4 drwx------ 74 hh hh 4096 april 21 16:05 /home/hh/div 2687210 4 drwx------ 2 hh hh 4096 april 21 21:25 /home/hh/div/parkering
## Forklar kort hva kommandoen gjør og hvilken informasjon output gir deg. For å finne ut av hva opsjonene betyr, kan du se i manual-siden for kommandoen find:

    man find
## Denne manualsiden kan du også få bruk for i oppgaven om bash-scripting.

    find kommado - søke etter filer i linux

    etter første / legges path inn
     -type d er for type filer (mapper)
     -newermt tid for sist modifikasjon
     -ls lister opp alle 

    Denne kommandoen lister opp alle mapper redigert etter dato nevnt over. 

---
<br><br>

# Bash-scripting

# 11
## Denne oppgaven er basert på en sann historie.... En IT-forsker bruker en Linux-server med host-navn research3 til å kjøre maskinlæring-proggrammer i python ved å kjøre følgende kommando i et bash-shell:
    research3:~$ python runML.py p3600-100.cnf
## Dette programmet tar omtrent en time på å kjøre ferdig og skriver resultatet til en fil i samme mappe. Forskeren har i samme mappe totalt 30 forskjellige input-filer, alle med filendelse .cnf, og ønsker å utnytte alle CPUene på serveren til å kjøre alle de 30 jobbene i parallell. Serveren research3 har 32 uavhengige CPUer. Forskeren ber deg derfor om hjelp til å skrive et bash-script som hun kan kjøre på serveren i mappen der de 30 input- filene ligger, slik at hun ikke må kjøre en jobb av gangen fra kommandolinjen. Skriv et slikt bash-script:

# Svar

    for file in *.cnf; 
    do  
        python runML.py "$file" &
    done

---
<br><br>

# 12
## Forskeren spør deg om omtrent hvor lang tid du tror det vil ta for scriptet å fullføre alle beregningene. Gi henne et begrunnet svar.

    32 uvhengige cpu`er
    Vår bash script vil kjøre alle de 30 filene samtidig.

    siden det tok ca 1 time på en fil vil det også ta 1 time totalt på alle de 30 filene fordi de kjører på hver sin cpu. Dette sørger vi for i vår script ved å legge inn & etter kommandoen for kjøring. 


---
<br><br>

# 13
## Forskeren skal hente barn i barnehagen om en halv time og ønsker derfor å sette igang scriptet på en slik måte at hun kan logge ut fra serveren research3 når hun går for dagen, men slik at scriptet fortsetter å kjøre. Hun vil også gjerne kunne logge inn via ssh hjemmefra senere på kvelden og se resultatfilene. Og hun vil også gjerne kunne se output som python-programmet gir direkte til konsollet, inkludert eventulle feilmeldinger. Forklar kort hvordan hun kan oppnå dette, og skriv ned hvilke kommandoer hun må kjøre på research3 før hun går og hvilke hun må kjøre hjemmefra.



##
    > file.txt > feil.txt

---

<br><br>

# 14

## Lag et bash-script som skriver ut en oversikt over hvor mange linker, filer og kataloger(mapper) det finnes i katalogen scriptet kjøres fra og i alle dens underkataloger. Output fra scriptet skal se tilsvarende ut som dette:
    Filer: 129
    Kataloger: 4
    Linker: 0

```bash
COUNTFILE=0
COUNTDIR=0
COUNTLINK=0
for i in $(find .)
do
if [[ -f “$i” ]]; then
((COUNTFILE++))
elif [[ -d “$i” ]]; then
((COUNTDIR++))
elif [[ -L “$i” ]]; then
((COUNTLINK++))
fi
done
echo “$COUNTFILE files found”
echo “$COUNTDIR directories found”
echo “$COUNTLINK links found”
```

---
<br><br>

