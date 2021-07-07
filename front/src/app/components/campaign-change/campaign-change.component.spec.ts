import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CampaignChangeComponent } from './campaign-change.component';

describe('CampaignChangeComponent', () => {
  let component: CampaignChangeComponent;
  let fixture: ComponentFixture<CampaignChangeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CampaignChangeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CampaignChangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
