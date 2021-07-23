import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CovidIndiaOrgApiDataComponent } from './covid-india-org-api-data.component';

describe('CovidIndiaOrgApiDataComponent', () => {
  let component: CovidIndiaOrgApiDataComponent;
  let fixture: ComponentFixture<CovidIndiaOrgApiDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CovidIndiaOrgApiDataComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CovidIndiaOrgApiDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
