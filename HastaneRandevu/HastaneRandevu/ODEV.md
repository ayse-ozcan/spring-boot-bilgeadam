# 1.Soru
    Bir doktorun 1 aylik donemde baktigi hasta sayisi nedir?
    Cevap: 
# 2.Soru
    Bir hastanin 1 yillik donemde hastalanma orani(aya gore dagilimi) nedir?
    Cevap:
# 3.Soru
    Insanlar hangi branslarda daha cok hasta oluyor?
    Cevap: en cok tekrar eden doktorid-bransad
```sql
select tr.doktorid, count(tr.doktorid) as mf from tblrandevu tr group by doktorid order by count(tr.doktorid) desc limit 1
```
```sql
select tr.doktorid, count(tr.doktorid) as mf, br.ad from (tblrandevu 
tr join tbldoktor dr on dr.id = tr.doktorid) join tblbrans br on 
br.id = dr.bransid group by tr.doktorid, br.ad order by count(tr.doktorid) desc limit 1
```

