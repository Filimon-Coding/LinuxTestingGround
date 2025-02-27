# Eksamen Vår 2018

# Linux Kommandolinje

## 1(a)
## Hva blir i et standard bash-shell resultatet av kommandoen $ move /bin/rm /usr/bin

## Velg ett alternativ

* move: command not found
* move: cannot move '/bin/rm' to '/usr/bin/rm': Permission denied 
* move: cannot * open '/bin/rm' for reading: Permission denied 
* Filen /bin/rm flyttes til katalogen /usr/bin
* Filen /bin/rm flyttes til filen /usr/bin

# Svar 

    * move: command not found

---
<br><br>

## 1(b)
## Hvilken kommando utfører kommandoen hostname på serveren os3.vlab.cs.hioa.no?
## Velg ett alternativ

* scp hostname os3.vlab.cs.hioa.no 
* ssh hostname os3.vlab.cs.hioa.no 
* ssh os3.vlab.cs.hioa.no hostname 
* ssh hostname@os3.vlab.cs.hioa.no 
* scp os3.vlab.cs.hioa.no:hostname . 
* wget os3.vlab.cs.hioa.no/hostname

# Svar
    ssh os3.vlab.cs.hioa.no hostname 


---

<br><br>

## 1(c)

## Du har en fil readme.txt og utfører kommandoen $ cat readme.txt > /dev/null Hva skjer?

* Innholdet i readme.txt legges til innholdet i filen /dev/null
* Output fra cat omdirigeres til /dev/null og forsvinner
* Innholdet i readme.txt slettes
* En ny tom fil med navn /dev/null lages
* Innholdet i readme.txt lagres i filen /dev/null

# Svar
    Output fra cat omdirigeres til /dev/null og forsvinner

--- 
<br><br>

## 1 (d)

## Du har en fil biler med følgende innhold: $ cat biler
    student bmw 500000
    haugerud berlingo 150000
    kyrre elbil 90000
## Hvilken Linux-kommando fører til følgende resultat?
    $ kommando
    haugerud berlingo 150000 
    student bmw 500000
    kyrre elbil 90000

## Velg ett alternativ
* sort -n biler
* sort -r -k 1 biler 
* sort -n -r -k biler 
* sort biler
* sort -n -k 3 biler 
* sort -k 2 biler

# Sort
    sort -k 2 biler

---
<br>
<br>

## 1(e)
## Gitt følgende fil med navn index.html:
    $ cat index.html <!DOCTYPE html>
```HTML

 <html itemscope itemtype="http://schema.org/Article" xmlns="http://www.w3.org/1999/xhtml" xml:lang="no" lang="no">
<head>
<title>Hjem - HiOA</title>
<meta name="Content-Type" content="text/html; charset=utf-8" /> <meta name="Content-language" content="no-bokmaal" />
<meta name="MSSmartTagsPreventParsing" content="TRUE" /> <meta name="generator" content="eZ Publish" />
<meta name="title" content="Hjem" />
<meta itemprop="name" content="Hjem">
<meta name="author" content="" />
<meta name="p:domain_verify" content="3a11dc5033d5012ab4dce032cb87920c"/>

```

Hvilken kommando gir følgende output?

    $ kommando
    Content-Type 
    Content-language 
    MSSmartTagsPreventParsing 
    generator
    title

## Velg ett alternativ
* cat index.html | grep name | tail -n 5
* tail -n 5 index.html | grep name | cut -d\" -f 4
* grep name index.html | head -n 5 | cut -d\" -f 2
* cat index.html | cut -f 5 | grep name | awk '{print $2}'

# Svar

    grep name index.html | head -n 5 | cut -d\" -f 2


---
<br><br>

# Bash-Scripting

## 2
## I denne oppgaven skal du lage et shell-script med navn dsh som setter opp et lite distribuert shell som du kan bruke til å kjøre kommandoer på andre Linux-maskiner som du har ssh-tilgang til.

## Brukeren som skal kjøre scriptet har en fil som heter ~/hosts og som innholder navnet på andre Linux-hosts som eieren av scriptet har tilgang til med ssh. Denne tilgangen er satt opp med ssh-nøkler, slik at brukeren kan logge seg inn til disse Linux-maskinene uten å taste passord. Helt til slutt i oppgaveteksten vises et eksempel på hvordan dsh skal virke når man bruker det og i dette tilfellet innholder ~/hosts følgende:

    $ cat ~/hosts 
    nexus.cs.hioa.no 
    studssh.cs.hioa.no 
    trident2.vlab.cs.hioa.no 
    $

## Når scriptet dsh kjøres, kan du anta at alle hosts i ~/hosts er oppe og kan nås med ssh uten å taste passord. Det som skal skje når du starter bash-scriptet dsh er at du får opp et prompt dsh$ og hvis du skriver inne en kommando til dette shellet så skal den utføres på den lokale maskinen (rex i dette eksempelet) og på alle maskiner som ligger i filen ~/hosts og resultatet vises i terminalen som vist under. Ett unntak er hvis brukeren skriver inn kommandoen exit til $dsh, da skal shellet avsluttes og brukeren skal komme tilbake til det vanlige lokale bash- shellet. Dette er vist helt til slutt i eksempelet under.

## Om du ikke husker syntaks for noen av bash-kommandoene du kan velge å bruke i dette scriptet, kan du se på denne hjelpefilen.

## I eksempelet under er alle kommandoer som brukeren skriver inn vist med uthevet font.

```Powershell
$ ./dsh
dsh$ whoami
#### rex ####
haugerud
#### nexus.cs.hioa.no ####
haugerud
#### studssh.cs.hioa.no ####
haugerud
#### trident2.vlab.cs.hioa.no ####
haugerud
dsh$ uname -r
#### rex ####
4.4.0-119-generic
#### nexus.cs.hioa.no ####
4.4.0-93-generic
#### studssh.cs.hioa.no ####
4.4.0-101-generic
#### trident2.vlab.cs.hioa.no ####
4.4.0-116-generic
dsh$ hostname
#### rex ####
rex
#### nexus.cs.hioa.no ####
nexus
#### studssh.cs.hioa.no ####
studssh
#### trident2.vlab.cs.hioa.no ####
trident2
dsh$ php -version
#### rex ####
PHP 7.0.28-0ubuntu0.16.04.1 (cli) ( NTS )
Copyright (c) 1997-2017 The PHP Group
Zend Engine v3.0.0, Copyright (c) 1998-2017 Zend Technologies
with Zend OPcache v7.0.28-0ubuntu0.16.04.1, Copyright (c) 1999-2017, by Zend Technologies #### nexus.cs.hioa.no ####
PHP 7.0.22-0ubuntu0.16.04.1 (cli) ( NTS )
Copyright (c) 1997-2017 The PHP Group
Zend Engine v3.0.0, Copyright (c) 1998-2017 Zend Technologies
with Zend OPcache v7.0.22-0ubuntu0.16.04.1, Copyright (c) 1999-2017, by Zend Technologies
 #### studssh.cs.hioa.no ####
4/19
 
DATA2500 2018
bash: php: command not found #### trident2.vlab.cs.hioa.no #### bash: php: command not found dsh$ exit
Avslutter dsh
$
```



---

<br>
<br>

## 3(a)
## Hva slags kode er listet opp i venstre kolonne?

<img src="Skjermbilde 2022-05-06 kl. 13.46.18.png">

    ls -l script.sh - bash
    getstatic #18 -Java bytecode
    Get-ChildItem - PowerShell
    #include <stdio.h> - C
    add %rdx, %rbx - Assembly

---

<br><br>

## 3(b)
## Du kompilerer et C-program med gcc prog.c Hva inneholder filen a.out etterpå?

# Svar:

    Maskinkode

---

<br><br>

## 3(c)
## Du kompilerer et C-program med gcc -S prog.c Hva inneholder filen prog.s etterpå?


# Svar:

    Assembly code


## 3(d)

## Anta at du har følgende C-program med navn svar.c på en Linux-maskin:
```C
#include <stdio.h> 
int svar = 41;
void enlinje()
{ 
    svar++; 
    
}
int main ()
{ 
    printf("Svar = %d\n", svar); 
    printf("Kaller enlinje()...\n"); enlinje();
    printf("Svar = %d\n", svar);
}
```
  Forklar kort hvordan du kompilerer og kjører dette programmet i et bash-shell og hva output fra programmet blir når du kjører det.

# Svar:

     Du kompilerer ved bruk av gcc svar.c som gir en a.out som kan bli kjørt på denne måten:
      ./a.out
    Resultatet av programmet blir 42


## 3(e)
## Du endrer litt på svar.c slik at det ser slik ut
```C
#include <stdio.h> 
int svar = 41;
extern void enlinje(); 
int main ()
{
     
    printf("Svar = %d\n", svar); 
    printf("Kaller enlinje()...\n"); 
    enlinje();
    printf("Svar = %d\n", svar);
}

    //og lager i tillegg et program en.c som ser slik ut: 
    
    void enlinje()
{ 
    extern int svar; 
    svar++;
}

```

Forklar kort hva følgende tre kommandoer gjør:

    $ gcc -c svar.c -o svar 
    $ gcc -c en.c -o en
    $ gcc svar en -o run


og hvordan du nå kan kjøre programmet. Restultatet blir eksakt det samme som når du kjørte programmet i forrige oppgave. Forklar kort hvorfor resultatet blir det samme.

# Svar:

    Første linje kompilerer c programmet svar.c og kaller den svar
    Andre linje kompilerer c programmet en.c og kaller den en
    tredje linje kompilerer begge c programmene og linker dem sammen og kaller den run

---


<br><br>

## 3(f)
## Du kjører så kommandoen
    $ gcc -S en.c
## og det lages da en fil en.s med følgende innhold:
    .file "en.c"
    .text
    .globl enlinje
    .type enlinje, @function
    enlinje: .LFB0:
    .cfi_startproc
    pushq %rbp .cfi_def_cfa_offset 16 .cfi_offset 6, -16
    movq %rsp, %rbp .cfi_def_cfa_register 6
    movl
    addl
    movl
    nop
    popq %rbp .cfi_def_cfa 7, 8 ret .cfi_endproc
    svar(%rip), %eax $1, %eax
    %eax, svar(%rip)
    .LFE0:
    .size enlinje, .-enlinje
    .ident "GCC: (Ubuntu 5.4.0-6ubuntu1~16.04.9) 5.4.0 20160609" .section .note.GNU-stack,"",@progbits
## Forklar kort hva innholdet av denne filen er og spesielt hva de tre helt sentrale kodelinjene gjør. (Merk: svar(%rip) er en minnereferanse til der i RAM hvor den globale variabelen svar ligger).

    movl svar(%rip), 
    %eax addl $1, %eax
    movl %eax, svar(%rip)

<br>

    Assemblykode av en.c koden. 

    movl svar(%rip), %eax -> svar flyttes fra RAM til eax
    addl $1, %eax -> Adderer 1 til eax, her ligger svar fra før. 1 + svar
    movl %eax, svar(%rip) -> flyter eax til RAM - resultatet av svar + 1

---
<br><br>

## 3(g)
## Du lager nå en fil minimal.s med følgende innhold
    .globl enlinje 
    enlinje:
    incl svar(%rip) ret
## og lar den erstatte en.s ved å kjøre kommandoen
    $ gcc svar minimal.s -o run
## Når du nå kjører programmet får du nøyaktig samme resultat. Forklar kort hvorfor minimal.s kan erstatte filen en.s.
    
    Denne asembly koden henter først inn enlinje. Der etter øker svar variabelen med 1 ved hjelp av incl metoden og deretter returnerer den.

---
<br><br>

# Synkronisering

## 4(a)
## Før du gjør denne oppgaven bør du gjøre forrige oppgave C og Assembly da funksjonen enlinje() også brukes i denne oppgaven og erfaringene fra den forrige oppgaven er viktige for å løse denne om synkronisering.
## Studer programmet thread.c og forklar i korte trekk det vesentligste som skjer når det kjøres.
```C
#include <stdio.h> 
#include <stdlib.h> 
#include <pthread.h>

int svar = 0;

extern void enlinje(); 

void *inc()
{ 
    printf("Starter; svar verdi: %d\n", svar); 
    for (int i = 0; i < 10000000; i++) 
    { 
        enlinje(); 
    
    }
} 

printf("Avslutter; svar verdi: %d\n", svar);

int main()
{
    pthread_t thread1, thread2;

    pthread_create( &thread1, NULL, inc,NULL); 

    pthread_create( &thread2, NULL, inc, NULL);

    pthread_join( thread1, NULL); pthread_join( thread2, NULL);

    printf("Main avslutter; svar verdi: %d\n", svar);

    exit(0); 

}

```
### Funksjonen enlinje() er den samme som i oppgaven om C og Assembly og ligger i filen en.c:

```C
void enlinje()
{ 
    extern int svar; 
    svar++;
}
```
## 

# Svar
### ** I main() startes det opp to tr ̊ader (pthreads) som vil scheduleres uavhengig av hverandre av kjernen og dermed kjøres samtidig (p ̊a hver sin CPU-core n ̊ar systemet har flere enn en). Begge tr ̊adene kaller funksjonen inc() som g ̊ar i en løkke og kaller den eksterne funksjonen enlinje() 10 millioner ganger. Kallene p ̊a pthread join() gjør at main() venter til begge tr ̊adene er ferdige og skriver s ̊a ut verdien av den felles variabelen svar og avslutter. Hvis tr ̊adene ikke ødelegger for hverandre, burde sluttsvaret bli 20 millioner.)**



## 4(b)
## På en Linux maskin med 8 CPU'er kompilerer du programmene i et bash shell på følgende måte:
    $ gcc -c en.c -o en
    $ gcc -c -pthread thread.c -o thread $ gcc -pthread en thread -o run
## Deretter kjører du programmet to ganger og resultatet blir følgende:
    $ ./run
    Starter; svar verdi: 0
    Starter; svar verdi: 356150 Avslutter; svar verdi: 10112917 Avslutter; svar verdi: 10300354 Main avslutter; svar verdi: 10300354 $ ./run
    Starter; svar verdi: 0
    Starter; svar verdi: 618427 Avslutter; svar verdi: 6893160 Avslutter; svar verdi: 10868668 Main avslutter; svar verdi: 10868668 $
## Du kjører programmet 10 ganger til og får aldri det samme svaret. Forklar kort disse resultatene og hva som kan være årsaken til at resultatene blir forskjellige når samme program kjøres flere ganger.

# Svar

## ***De to tr ̊adene vil kjøre p ̊a hver sin CPU og uavhengig av hverandre hente ut verdien av svar og øke den med 10 millioner. Men de synkroniserer ikke med hverandre n ̊ar verdier hentes og lagres. Hvis en CPU henter ut verdien av svar fra RAM, øker med en og legger tilbake, vil en annen CPU kunne hente samme verdi av svar, øke denne legge tilbake, og en av oppdateringen vil da ikke bli gjort. Dette skjer ofte og nesten halvparten av oppdateringene forsvinner(De to CPUene har forskjellig cache, men disse holdes synkronisert).**