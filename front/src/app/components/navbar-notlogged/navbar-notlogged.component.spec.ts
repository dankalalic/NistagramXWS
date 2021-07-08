import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarNotloggedComponent } from './navbar-notlogged.component';

describe('NavbarNotloggedComponent', () => {
  let component: NavbarNotloggedComponent;
  let fixture: ComponentFixture<NavbarNotloggedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarNotloggedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarNotloggedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
