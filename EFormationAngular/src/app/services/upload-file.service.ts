import {Injectable} from '@angular/core';
import {HttpClient, HttpRequest, HttpEvent, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { AuthService } from './auth.service';
 
@Injectable({
  providedIn: 'root'
})
export class UploadFileService {
 
  constructor(private http: HttpClient, private auth: AuthService) {}
 
  pushFileToStorage(file: File, username:string): Observable<HttpEvent<{}>> {
    let formdata: FormData = new FormData();
    let headers = new HttpHeaders().set('Authorization', 'Bearer '+ this.auth.getToken());
    formdata.append('file', file);
    formdata.append('username', username);
    const req = new HttpRequest('POST', 'http://localhost:8080/savefile', formdata, {
      headers,
      reportProgress: true,
      responseType: 'json'
    });
 
    return this.http.request(req);
  }
 
  getFile(username:string){
    let headers = new HttpHeaders().set('Authorization', 'Bearer '+this.auth.getToken())
    let params = new HttpParams().set('username', username);
    return this.http.get('http://localhost:8080/getfile', {headers,params});
  }
}