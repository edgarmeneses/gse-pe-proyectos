import PyPDF2
import sys

def extract_text_from_pdf(pdf_path, output_path):
    """Extract text from PDF and save to text file."""
    try:
        with open(pdf_path, 'rb') as file:
            pdf_reader = PyPDF2.PdfReader(file)
            text_content = []
            
            print(f"Total pages: {len(pdf_reader.pages)}")
            
            for page_num in range(len(pdf_reader.pages)):
                page = pdf_reader.pages[page_num]
                text = page.extract_text()
                text_content.append(f"\n--- Page {page_num + 1} ---\n")
                text_content.append(text)
            
            # Write to output file
            with open(output_path, 'w', encoding='utf-8') as output:
                output.write(''.join(text_content))
            
            print(f"Content extracted successfully to {output_path}")
            
    except Exception as e:
        print(f"Error extracting PDF: {e}")
        sys.exit(1)

if __name__ == "__main__":
    pdf_path = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\MsDominioParentesco\Microservicio MsDominioParentesco V1.0.pdf"
    output_path = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\MsDominioParentesco\pdf_extracted_content.txt"
    extract_text_from_pdf(pdf_path, output_path)
