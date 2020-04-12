import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationElementsComponent } from './formation-elements.component';

describe('FormationElementsComponent', () => {
  let component: FormationElementsComponent;
  let fixture: ComponentFixture<FormationElementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormationElementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormationElementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
