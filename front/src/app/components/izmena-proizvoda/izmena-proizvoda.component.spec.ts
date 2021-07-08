import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IzmenaProizvodaComponent } from './izmena-proizvoda.component';

describe('IzmenaProizvodaComponent', () => {
  let component: IzmenaProizvodaComponent;
  let fixture: ComponentFixture<IzmenaProizvodaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IzmenaProizvodaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IzmenaProizvodaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
