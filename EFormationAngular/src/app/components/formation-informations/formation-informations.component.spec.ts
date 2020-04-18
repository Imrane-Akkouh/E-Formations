import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationInformationsComponent } from './formation-informations.component';

describe('FormationInformationsComponent', () => {
  let component: FormationInformationsComponent;
  let fixture: ComponentFixture<FormationInformationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormationInformationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormationInformationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
