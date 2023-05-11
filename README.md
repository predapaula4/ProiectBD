# ProiectBD

## Pasi de rulare ai aplicatiei:

1. Instalati GitHub Desktop https://desktop.github.com, ultima versiune, in functie de capacitatile calculatorului dumneavoastra.
2. Copiati link-ul acestui repository in GitHub Desktop: in meniul de cautare accesati File-> Clone Repository-> URL, copiati URL-ul si alegeti locatia unde doriti sa salvati repo-ul.
3. Instalati PostgreSQL https://www.postgresql.org/download (de completat cum punem baza de date in postgreSQL). La configurare introduceti username-ul 'postgres' si parola '1234'
4. Instalati IntelliJ IDEA https://www.jetbrains.com/idea/download/#section=windows, ultima versiune. Dupa instalare selectati Open si alegeti folderul unde ati salvat repository-ul.
5. Asteptati cateva minute pentru a se instala toate dependintele necesare proiectului din IntelliJ.
6. Deschideti pgAdmin4, aplicatia pentru baza de date, si dati click drepata be 'Databases'->create-> Database..., denumiti baza de date 'Clinica', la owner alegeti 'postgres' si apasati Save.
7. Dupa ce v-ati facut o noua baza de date, in repository veti gasi un fisier ClinicaRecuperare.sql. Pe baza de date recent creata dati click dreapta-> Restore... Pentru 'Format' lasati Custom/ tar, la filename adaugati fisierul  ClinicaRecuperare.sql, iar la Role name selectati 'postgres' si Restore. In momentul de fata veti avea baza de date pe care s-a construit aplicatia, iar mai departe ne putem ocupa de configurarea legaturii dintre proiectul din IntelliJ IDEA si legatura cu baza de date.
8. In proiectul din IntelliJ IDEA mergeti in src/main/resources/application.properties. In acest fisier va trebui sa configurati datele pentru conectarea la baza de date si anume username, password si default_schema. Daca atunci cand ati instalat postgres ati introdus username-ul si parola dupa explicatiile date, atunci nu mai trebuie modificate. In schimb, pt schema in loc de 'clinica', modificati in 'public'. In urma acestor modificari cand rulati aplicatia (src/main/java/com.example.clinica/ClinicaApplication) va aparea un meniu.


