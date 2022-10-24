import { Injectable } from '@angular/core';
import { HttpClient}  from '@angular/common/http';
import { map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {
  private url1='http://localhost:8085/api/admin/item/all';

  constructor(private httpClient:HttpClient) { }

  getPost(){
    return this.httpClient.get(this.url1);
   }
   
   postFood(data:any){
    return this.httpClient.post("http://localhost:8085/api/item/add",data)
    .pipe(map((res:any)=>{return res;} )
   )}

   deleteFood(itemId:number){
    return this.httpClient.delete<any>("http://localhost:8085/api/item/delete/" +itemId)
   .pipe(map((res:any)=>{return res;} )
)
  }
}
