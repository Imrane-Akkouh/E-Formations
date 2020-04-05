import { Component, OnInit } from '@angular/core';
import { UploadFileService } from 'src/app/services/upload-file.service';
import { AuthService } from 'src/app/services/auth.service';


@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})
export class CvComponent implements OnInit {
  canSave: Boolean = false;
  pdfSrc: string = '';
  constructor(private ufs: UploadFileService, private auth: AuthService) {
    this.ufs.getFile(this.auth.getCurrentUser().username).subscribe(res => {
      if(res !=null){
      const blob = this.b64toBlob((res as any).file.data, 'application/pdf');
      this.pdfSrc = URL.createObjectURL(blob);
      }
      
  });
}

ngOnInit(): void {
}

onFileSelected() {
  let pdf: any = document.querySelector("#file");

  if (typeof (FileReader) !== 'undefined') {
    let reader = new FileReader();
    this.canSave = false;
    reader.onload = (e: any) => {
      this.pdfSrc = e.target.result;
      console.log(this.pdfSrc);
      if (this.pdfSrc != '') {
        this.canSave = true;
      }
    }

    reader.readAsArrayBuffer(pdf.files[0]);
  }
}

saveFile() {
  let pdf: any = document.querySelector("#file");
  this.ufs.pushFileToStorage(pdf.files[0], this.auth.getCurrentUser().username).subscribe(res => {
    console.log(res);
  });
}

b64toBlob = (b64Data, contentType='', sliceSize=512) => {
  const byteCharacters = atob(b64Data);
  const byteArrays = [];

  for (let offset = 0; offset < byteCharacters.length; offset += sliceSize) {
    const slice = byteCharacters.slice(offset, offset + sliceSize);

    const byteNumbers = new Array(slice.length);
    for (let i = 0; i < slice.length; i++) {
      byteNumbers[i] = slice.charCodeAt(i);
    }

    const byteArray = new Uint8Array(byteNumbers);
    byteArrays.push(byteArray);
  }

  const blob = new Blob(byteArrays, {type: contentType});
  return blob;
}
}
