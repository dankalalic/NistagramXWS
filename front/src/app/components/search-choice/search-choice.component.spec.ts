import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchChoiceComponent } from './search-choice.component';

describe('SearchChoiceComponent', () => {
  let component: SearchChoiceComponent;
  let fixture: ComponentFixture<SearchChoiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchChoiceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
